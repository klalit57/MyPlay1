package com.lalit;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String [] args){


        Album album1= new Album("Album1","AC/DC");

        album1.addSong("TNT", 4.5);
        album1.addSong("Highway to Hell", 3.5);
        album1.addSong("Thunder Struck", 5.0);
        albums.add(album1);

        Album album2= new Album("Album2","Eminem");
        album2.addSong("Rap God", 4.5);
        album2.addSong("Lose Yourself", 3.5);
        album2.addSong("Not Afraid", 4.5);
        albums.add(album2);

        LinkedList<Song> playList1= new LinkedList<>();
        albums.get(0).addToPlayList("TNT",playList1);
        albums.get(0).addToPlayList("Highway to Hell",playList1);
        albums.get(1).addToPlayList("Rap God",playList1);
        albums.get(1).addToPlayList("Lose Yourself",playList1);

        play(playList1);
       }

       public static void play(LinkedList<Song> playList){
           Scanner sc= new Scanner(System.in);
           boolean quit=false;
           boolean forward=true;
           ListIterator<Song> listIterator= playList.listIterator();

           if(playList.size()==0){
               System.out.println("This playlist have no song");
           }
           else{
               System.out.println("Now Playing"+listIterator.next().toString());
               printMenu();
           }
           while(!quit){
               int action=sc.nextInt();
               sc.nextLine();
               switch(action) {
                   case 0:
                       System.out.println("playList complete");
                       quit = true;
                       break;
                   case 1:
                       if (!forward) {
                           if ((listIterator.hasNext())) {
                               listIterator.next();
                           }
                           forward = true;
                       }
                       if (listIterator.hasNext()) {
                           System.out.println("Now Playing" + listIterator.next().toString());
                       } else {
                           System.out.println("no song available, reached end of list");
                           forward = false;
                       }
                       break;

                   case 2:
                       if (forward) {
                           if (listIterator.hasPrevious()) {
                               listIterator.previous();
                           }
                           forward = false;
                       }
                       if (listIterator.hasPrevious()) {
                           System.out.println("now playing " + listIterator.previous().toString());
                       } else {
                           System.out.println("we are the first song");
                           forward = false;
                       }
                       break;
                   case 3:
                       if (forward) {
                           if (listIterator.hasPrevious()) {
                               System.out.println("now playing " + listIterator.previous().toString());
                               forward = false;
                           } else {
                               System.out.println("we are at the start of list");
                           }
                       }
                       else {
                           if (listIterator.hasNext()) {
                               System.out.println("now playing " + listIterator.next().toString());
                               forward = true;
                           } else {
                               System.out.println("we are reached at at end of list");
                           }
                       }
                       break;
                   case 4:
                       printList(playList);
                       break;
                   case 5:
                       printMenu();
                       break;
                   case 6:
                       if(playList.size()>0){
                           listIterator.remove();
                           if(listIterator.hasNext()){
                               System.out.println("now playing "+listIterator.next().toString());
                           }
                           else{
                               if(listIterator.hasPrevious()){
                                   System.out.println("now playong "+listIterator.previous().toString());
                               }
                           }
                       }
               }
           }
          }

          private static void printMenu(){ System.out.println("Available options\n press");
           System.out.println("0- to quit\n"+
                   "1-to play next song\n"+
                   "2-to play previous song\n"+
                   "3-to replay the current song\n"+
                   "4-list of all songs\n"+
                   "5-print all available options\n"+
                   "6-delete current song");
       }

       private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
           System.out.println("---------------");

           while(iterator.hasNext()){
               System.out.println(iterator.next());
           }
           System.out.println("---------------");
       }
}
