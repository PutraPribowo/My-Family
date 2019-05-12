package com.developerputra.myfamily.model;

import java.util.ArrayList;

public class KeluargaData {

    public static String[][] data = new String[][]{
            {"Sudarto" , "Ayah" , "Merupakan kepala keluarga yang selalu menjadi pedoman dikeluarga dan sangat aku cintai." , "https://cdn0.iconfinder.com/data/icons/user-pictures/100/malecostume-512.png"},
            {"Tukinah", "Ibu", "Merupakan ibu yang tangguh dan sangat aku cintai dan aku sayangi." , "https://wiratara.files.wordpress.com/2009/02/female-icon.png?w=720"},
            {"Agus Setiawan" , "Kakak" , "Orangnya selalu menjadi abang yang baik dan selalu menasehati aku." , "http://sanggarseniseulaweuet.com/wp-content/uploads/2017/09/icon-cowok.png"},
            {"Feri Kurnia", "Mbk", "Orangnya cerewet tetapi baik hati dan selalu menjadi mbk yang baik." , "https://image.winudf.com/v2/image/Y29tLnRvb3BjaGFydHMua29kZWtlcmFzY293b2tjZXdla19pY29uXzE1MjMwNzYxNjBfMDE5/icon.png?w=170&fakeurl=1&type=.png"},
            {"Putra Pribowo", "Adek", "Aku adalah seorang developer dan aku sedang menempuh S1 Ilmu Komputer dan ingin melanjutkan studi S2 di Jepang dengan beasiswa LPDP." , "https://stickershop.line-scdn.net/stickershop/v1/product/1413821/LINEStorePC/main.png;compress=true"}
    };

    public static ArrayList<Keluarga> getListData(){
        Keluarga keluarga = null;
        ArrayList<Keluarga> list = new ArrayList<>();
        for (int i = 0; i<data.length; i++){
            keluarga = new Keluarga();
            keluarga.setName(data[i][0]);
            keluarga.setStatus(data[i][1]);
            keluarga.setDetail(data[i][2]);
            keluarga.setPhoto(data[i][3]);

            list.add(keluarga);
        }

        return list;
    }
}

