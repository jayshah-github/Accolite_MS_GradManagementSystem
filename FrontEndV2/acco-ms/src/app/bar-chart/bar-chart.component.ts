// bar-chart.component.ts
import { HttpErrorResponse } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { ChartDataSets, ChartType, ChartOptions } from 'chart.js';
import { Label } from 'ng2-charts';
import { GradService } from '../grad.service';
import { Institute } from '../institute';
import { Skill } from '../skill';

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnInit {

  skills: Skill[] =[];
  instis:Institute[]=[];
  joinLocs:Location[]=[];
  joinYear:String[]=[];
  selectedParam: string;
  selectedCar: string;
  xParamVal:String[]=[];
  xParamOptions:String[]=['skill','institute','joining location'
 ,'join year'
]

  
  constructor(private gradService:GradService){}
  ngOnInit(): void {
    this.selectedParam="joining location";
   this.getLabels("joining location");

  }
 

  barChartOptions: ChartOptions = {
    responsive: true,
    scales: { xAxes: [{}], yAxes: [{}] },
  };
  barChartLabels: Label[] = ['2013', '2014'];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [
    { data: [2500], label: 'Company A' }
  ];

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
    this.gradService.getLabels(label).subscribe(
      (respone)=>{
        console.log(respone)
        this.barChartLabels=respone.labels;
        this.barChartData[0] = respone.chartData
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
}
