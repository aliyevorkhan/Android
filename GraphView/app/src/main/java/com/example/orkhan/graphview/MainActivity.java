package com.example.orkhan.graphview;

import android.accessibilityservice.AccessibilityService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double x, y;

        x = -5.0;

        GraphView graphView = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();

        for(int i =0; i<500; i++){
            x = x + 0.1;
            y = Math.sin(x); // y = 5 * x + 1;
            series.appendData(new DataPoint(x, y), true, 500);
        }
        graphView.addSeries(series);
    }
}
