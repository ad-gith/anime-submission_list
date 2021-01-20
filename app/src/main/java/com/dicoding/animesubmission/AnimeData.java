package com.dicoding.animesubmission;

import java.util.ArrayList;
import java.util.Collection;

public class AnimeData {
    public static String[][] data = new String[][]{
            {"One Piece", "Anime adventure tentang bajak laut Monkey D. Luffy", "https://upload.wikimedia.org/wikipedia/en/9/90/One_Piece%2C_Volume_61_Cover_%28Japanese%29.jpg","Adventure, Fantasy", "Eiichiro Oda", "Monkey D. Luffy berpetualang dilautan untuk menjadi raja bajak laut bersama dengan kru bajak lautnya"},
            {"Bleach", "Anime tentang kehidupan seorang shinigami bernama Ichigo Kurosaki", "https://upload.wikimedia.org/wikipedia/en/5/53/Bleach_cover_01.jpg","Adventure, Supernatural", "Tite Kubo", "Ichigo Kurosaki, seorang pelajar SMA yang memiliki kemampuan untuk melihat roh dan memulai kehidupan sebagai shinigami"},
            {"Gin Tama", "Anime bergenre komedi, action tentang kehidupan Sakata Gintoki", "https://upload.wikimedia.org/wikipedia/en/e/ee/Gintamavol01cover.jpg", "Adventure, Comedy, Science Fiction", "Hideaki Sorachi", "Sakata Gintoki bersama teman-temannya Shinpachi Shimura dan Kagura menjalani kehidupan sebagai freelancer pada masa alien Amanto menaklukkan wilayahnya"},
            {"Bakuman", "Anime tentang  mangaka yang mengejar impiannya dengan nama pena Ashirogi Muto", "https://upload.wikimedia.org/wikipedia/en/9/9f/Bakuman_Vol_1_Cover.jpg", "Comedy, Coming-of-age, Slice of Life", "Tsugumi Ohba and Takeshi Obata (as Illustrator)", "Bakuman berkisah tentang dua orang siswa kelas sembilan bernama Moritaka Mashiro dab Akito Takagi yang bercita-cita untuk menjadi pengarang manga terkenal"}
    };

    public static ArrayList<Anime> getListData(){
        Anime anime = null;
        ArrayList<Anime> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            anime = new Anime();
            anime.setName(data[i][0]);
            anime.setRemarks(data[i][1]);
            anime.setPhoto(data[i][2]);
            anime.setGenre(data[i][3]);
            anime.setWrittenby(data[i][4]);
            anime.setSynopsis(data[i][5]);
            list.add(anime);
        }
        return list;
    }
}
