package com.firststarservice.getgalleryphoto;

import java.io.InputStream;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

//ギャラリーから写真を取得してImageViewに表示する
public class MainActivity extends Activity {

private ImageView imgView;

private static final int REQUEST_GALLERY = 0;//リクエストコード　数字は任意

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView)findViewById(R.id.img1);

        // ギャラリーの呼び出し
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,REQUEST_GALLERY);

    }


    //ギャラリーからイメージを受け取る
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    	if(requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {

		  try {
			  
			  InputStream in = getContentResolver().openInputStream(data.getData());
			  
			  Bitmap img = BitmapFactory.decodeStream(in);
			
			  in.close();
	
			  imgView.setImageBitmap(img); 
		
		  } catch (Exception e) {
		
		  }

    	} 
    }
}
