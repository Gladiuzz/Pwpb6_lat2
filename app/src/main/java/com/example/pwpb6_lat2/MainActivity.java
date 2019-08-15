package com.example.pwpb6_lat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithDataActivity = (Button) findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);

        btnMoveWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveintent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveintent);
                break;

            case R.id.btn_move_with_data_activity:
                Intent movewithdataintent = new Intent(MainActivity.this, MoveWithDataActivity.class);

                movewithdataintent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Hasin Bashari P");
                movewithdataintent.putExtra(MoveWithDataActivity.EXTRA_AGE, 17);

                startActivity(movewithdataintent);
                break;

            case R.id.btn_move_activity_object:

                Person mPerson = new Person();
                mPerson.setName("Hasin Bashari P");
                mPerson.setAge(17);
                mPerson.setEmail("hasinbasharip@gmail.com");
                mPerson.setCity("Bandung");

                Intent movewithobjectintent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                movewithobjectintent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);

                startActivity(movewithobjectintent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "081320518412";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);

                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }

    }

}


