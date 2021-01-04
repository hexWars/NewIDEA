package com.cai.bigWorkLoser.effect;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {
    public static void music() {
        try {
            String s2 = Music.class.getResource("music/Okawari - Flower Dance (花之舞)(DJ版).mp3").toString();
            Media media2 = new Media(s2);
            MediaPlayer mp2 = new MediaPlayer(media2);


            // 用输入流打du开一音频文件
//            InputStream in = new FileInputStream("music/Okawari - Flower Dance (花之舞)(DJ版).mp3");//FIlename 是你加载的zhi声音文件如dao(“game.wav”)
//            // 从输入流中创建一个AudioStream对象
//            AudioStream as = new AudioStream(in);
//            AudioPlayer.player.start(as);//用静态成员player.start播放音乐
            //AudioPlayer.player.stop(as);//关闭音乐播放
            //如果要实现循环播放，则用下面的三句取代上面的“AudioPlayer.player.start(as);”这句
    /*AudioData data = as.getData();
    　　ContinuousAudioDataStream gg= new ContinuousAudioDataStream (data);
    　　AudioPlayer.player.start(gg);// Play audio.
    　　*/
            //如果要用一个 URL 做为声音流的源(source)，则用下面的代码所示替换输入流来创建声音流：
            /*AudioStream as = new AudioStream (url.openStream());
             */
        } catch (Exception e){
            System.out.println("音乐播放失败");
        }
    }
}