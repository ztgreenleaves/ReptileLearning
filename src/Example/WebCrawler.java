package Example;

import java.io.*;
import java.net.*;

public class WebCrawler{

    public static void main(String[] args){
        runcrawler t1=new runcrawler();
        runcrawler t2=new runcrawler();
        runcrawler t3=new runcrawler();
        t1.start();
        t2.start();
        t3.start();     
    }
}

class runcrawler extends Thread{

    String s1="<a href=\"http://";
    String url="http://www.sina.com";
    static int i=0;
    static String [] urlconntion=new String[100];   

    public void run() {

        newCrawler cr=new newCrawler(url,s1,urlconntion);
        String s2=cr.find();
        while(urlconntion[90]==null){
            //线程锁，防止并发导致的线程安全
            synchronized(this)
            {
            if(s2==null){
                cr=new newCrawler(url,s1,urlconntion);
                s2=cr.find();
                 }
            System.out.println(s2);
            cr=new newCrawler(s2, s1,urlconntion);
            urlconntion[i++]=s2;        
            s2=cr.find();       
            }
        }       
    }   
}

 class newCrawler {

    String url=null;
    String prefix=null;
    //爬去过的url地址集合
    String[] urlconntion=null;

    //爬虫类的构造函数
    newCrawler(String url,String prefix,String[] urlconntion){

        this.url=url;
        this.prefix=prefix;
        this.urlconntion=urlconntion;

    }

    //根据类的url开始爬取新的url实现循环爬取
    public String find(){
        URL u=null;
        URLConnection con=null;
        BufferedReader bfr=null;
        String rpurl=null;
        try {
            u=new URL(url);
            con=u.openConnection();
            //模拟成用户，访问部分网站，部分网站会拒绝爬虫爬取
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream is=con.getInputStream();
            bfr=new BufferedReader(new InputStreamReader(is));
            String s;
            while((s=bfr.readLine())!=null){
                if(s.indexOf(prefix)>=0)
                     {

                        rpurl=getUrl(s);
                        if(urlrepetition(rpurl)!=-1){
                            return rpurl;
                        }

                     }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                bfr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;

    }

    //判断url是否被爬去过，如果被爬去可返回-1，如果没有则返回1
    public int urlrepetition(String rpurl){

        int i=0;
        while(urlconntion[i]!=null){
            if(urlconntion[i++].equals(rpurl)){
                return -1;
            }
        }
        return 1;
    }

    //从爬去过的源码中截取url地址；
    public String getUrl(String s){

        int index1=s.indexOf(prefix);
        s=s.substring(index1+9);
        int index2=s.indexOf("\"");
        s=s.substring(0,index2);
        return s;
    }

}