package kr.co.tjeit.baseballgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

import kr.co.tjeit.baseballgame.util.BaseballGameCheckUtil;

public class MainActivity extends AppCompatActivity {

    BaseballGameCheckUtil bgcUtil = new BaseballGameCheckUtil();
    private android.widget.EditText inputEdt;
    private android.widget.Button inputBtn;
    private android.widget.TextView resultTxt;
    private android.widget.TextView tryCountTxt;

    int tryCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tryCountTxt = (TextView) findViewById(R.id.tryCountTxt);
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.inputBtn = (Button) findViewById(R.id.inputBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);

        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tryCount++;

                tryCountTxt.setText(tryCount + "");

                int inpuNum = Integer.parseInt(inputEdt.getText().toString());
                Log.d("input", inpuNum + "");

                // => 문자를 숫자로 바꿔야할 필요가 있다.

                int[] result = bgcUtil.checkInputToProblem(inpuNum);


                resultTxt.setText(result[0] + "S" + result[1] + "B");
                
                if (result[0] == 3) {
                    Toast.makeText(MainActivity.this, "축하합니다. 정답입니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
