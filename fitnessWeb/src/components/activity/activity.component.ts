import { Component } from '@angular/core';
import { SharedModule } from '../../app/shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageComponent, NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../app/service/user.service';
import { error } from 'console';

@Component({
  selector: 'app-activity',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './activity.component.html',
  styleUrl: './activity.component.scss',
})
export class ActivityComponent {
  gridstyle = {
    width: '100%',
    textAlign: 'center',
  };

  activityForm!: FormGroup;
  activities: any;

  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.activityForm = this.fb.group({
      caloriesBurned: [null, [Validators.required]],
      steps: [null, [Validators.required]],
      distance: [null, [Validators.required]],
      date: [null, [Validators.required]],
    });

    this.getAllActivities();
  }
  submitForm() {
    this.userService.postActivity(this.activityForm.value).subscribe(
      (res) => {
        this.message.success('suceesful posting', { nzDuration: 5000 });
        this.activityForm.reset();
        this.getAllActivities();
      },
      (error) => {
        this.message.error('Error while posting', { nzDuration: 5000 });
      }
    );
  }

  getAllActivities() {
    this.userService.getActivities().subscribe((res) => {
      this.activities = res;
      console.log(this.activities);
    });
  }
}
