import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { GradService } from '../grad.service';
import { Institute } from '../institute';
import { Location } from '../location';
import { NotificationService } from '../notification.service';
import { SearchComponent } from '../search/search.component';
import { Skill } from '../skill';

@Component({
  selector: 'app-add-grad',
  templateUrl: './add-grad.component.html',
  styleUrls: ['./add-grad.component.css']
})
export class AddGradComponent implements OnInit {
  

  constructor(public gradService:GradService,public dialogRef:MatDialogRef<SearchComponent>,
    private notificationService: NotificationService) { }

     locations :Location[]=[];
     institutes :Institute[]=[];
     
     skills :Skill[]=[];
  ngOnInit(): void {
    this.getLocs();
    this.getInsti();
    this.getSkills();
  }
  public getLocs():void{
    this.gradService.getLocations().subscribe(
      (respone :any)=>{
        this.locations=respone;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
  public getInsti():void{
    this.gradService.getInstitutes().subscribe(
      (respone :any)=>{
        this.institutes=respone;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
  public getSkills():void{
    this.gradService.getSkills().subscribe(
      (respone :any)=>{
        this.skills=respone;
      },
      (err:HttpErrorResponse)=>{
        alert(err.message);
      }
    );
  }
  public objectComparisonFunction = function( option, value ) : boolean {
    return option.id === value.id;
  }
  onClear() {
    this.gradService.form.reset();
    this.gradService.initializeFormGroup();
  }
  onSubmit() {
    if (this.gradService.form.valid) {
      if (!this.gradService.form.get('$key').value)
        {  console.log("nokey");
          this.gradService.addGrads(this.gradService.form.value).subscribe((res)=>{
            console.log(res);
          });
          this.notificationService.success(':: Submitted successfully');
          this.onClose();
        }else

      {
        console.log("key");
        this.gradService.updateGrads(this.gradService.form.value).subscribe((res)=>{
          console.log(res);
        });
      this.gradService.form.reset();
      this.gradService.initializeFormGroup();
      this.notificationService.success(':: updated successfully');
      this.onClose();
    }
  }
  }

  onClose() {
    this.gradService.form.reset();
    this.gradService.initializeFormGroup();
    this.dialogRef.close();
  }

}
