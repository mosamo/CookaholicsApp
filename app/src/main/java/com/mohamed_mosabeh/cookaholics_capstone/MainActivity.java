package com.mohamed_mosabeh.cookaholics_capstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    
    
    private FirebaseDatabase database;
    private DatabaseReference reference;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        database = FirebaseDatabase.getInstance("https://cookaholics-capstone-default-rtdb.asia-southeast1.firebasedatabase.app");
        reference = database.getReference("recipes");
    }
    
    public void myMethod(View view) {
        Toast.makeText(this, "Toasted!", Toast.LENGTH_SHORT).show();
        
        final TextView textView = findViewById(R.id.textView);
        
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(getApplicationContext(), "xxxx!", Toast.LENGTH_SHORT).show();
                String text = snapshot.child("1").child("name").getValue(String.class);
                textView.setText(text);
            }
    
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}