// pie-chart.component.ts
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType } from 'chart.js';
import { Label } from 'ng2-charts';
import { GradService } from '../grad.service';

@Component({
  selector: 'app-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent implements OnInit {
 
  selectedParam: string;
  xParamOptions:String[]=['skill','institute','joining location'
 ,'join year'
]

constructor(private gradService:GradService){}
  pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    tooltips: {
      enabled: true,
      mode: 'single',
      callbacks: {
        label: function (tooltipItems, data) {
          console.log(JSON.stringify(data.datasets[0].data));
          
          return data.datasets[0].data[tooltipItems.index] + ' %';
        }
      }
    },
  };

  pieChartLabels: Label[] = [];

  pieChartData: number[] =[];

  pieChartType: ChartType = 'pie';

  pieChartLegend = true;

  pieChartPlugins = [];

  pieChartColors = [
    {
      backgroundColor: ['rgba(255,0,0,0.3)', 'rgba(0,255,0,0.3)', 'rgba(0,0,255,0.3)'],
    },
  ];
  ngOnInit(): void {
    this.selectedParam="joining location";
    this.getLabels("joining location");
  }
  onShow(){
    if(this.selectedParam==="skill")
    {
      this.getLabels("skill");
    }else if(this.selectedParam==="institute"){
this.getLabels("institute");
    }else if(this.selectedParam==="join year"){
      this.getLabels("join year");
          }else{
      this.getLabels("joining location");
    }
  }
  public getLabels(label:String):void{
    this.gradService.getLabelsPie(label).subscribe(
      (respone)=>{
        console.log(respone)
        this.pieChartLabels=respone.labels;
        this.pieChartData = respone.chartData.data;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
}
