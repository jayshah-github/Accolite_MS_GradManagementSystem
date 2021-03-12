// doughnut-chart-component.ts
import { Component } from '@angular/core';
import { Label, MultiDataSet, Color } from 'ng2-charts';
import { ChartType } from 'chart.js';

@Component({
  selector: 'app-doughnut-chart',
  templateUrl: './doughnut-chart.component.html',
  styleUrls: ['./doughnut-chart.component.css']
})
export class DoughnutChartComponent {

  doughnutChartLabels: Label[] = ['PUBG', 'Call of Duty', 'Fortnite'];
  doughnutChartData: MultiDataSet = [
    [53, 30, 17]
  ];
  doughnutChartType: ChartType = 'doughnut';
}
