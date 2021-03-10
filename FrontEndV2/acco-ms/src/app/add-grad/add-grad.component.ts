import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { GradService } from '../grad.service';
import { NotificationService } from '../notification.service';
import { SearchComponent } from '../search/search.component';

@Component({
  selector: 'app-add-grad',
  templateUrl: './add-grad.component.html',
  styleUrls: ['./add-grad.component.css']
})
export class AddGradComponent implements OnInit {
  

  constructor(public gradService:GradService,public dialogRef:MatDialogRef<SearchComponent>,
    private notificationService: NotificationService) { }

  ngOnInit(): void {
    
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
