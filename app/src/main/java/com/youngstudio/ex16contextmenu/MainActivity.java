package com.youngstudio.ex16contextmenu;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.btn);

        //액티비티에게 btn객체를 ContextMenu로 등록
        this.registerForContextMenu(btn);
    }

    //ContextMenu로 등록된 뷰가 롱클릭되면
    //컨텍스트메뉴를 만드는 메소드가 자동으로 실행
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //menu폴더안에 context.xml문서를 읽어와서
        //Menu객체를 만들어주는(부풀려주는 inflate) 객체를 Context로 부터 얻어오기
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.context, menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }


    //컨텍스트메뉴의 아이템을 선택했을때
    //자동으로 실행되는 콜백메소드
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();
        switch (id){
            case R.id.menu_save:
                Toast.makeText(this, "SAVE", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_delete:
                Toast.makeText(this, "DELETE", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onContextItemSelected(item);
    }

    //onClick속성이 부여된 View가 클릭되면
    //자동으로 실행되는 메소드
    public void clickBtn(View v){
        Toast.makeText(this, "clicked!!", Toast.LENGTH_SHORT).show();
    }

}
