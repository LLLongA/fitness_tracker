import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../app/service/user.service';
import { SharedModule } from '../../app/shared/shared.module';
import { error } from 'console';

@Component({
  selector: 'app-goal',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './goal.component.html',
  styleUrl: './goal.component.scss',
})
export class GoalComponent {
  gridstyle = {
    width: '100%',
    textAlign: 'center',
  };

  goalForm!: FormGroup;
  goals: any;

  constructor(
    private fb: FormBuilder,
    private message: NzMessageService,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.goalForm = this.fb.group({
      description: [null, [Validators.required]],
      startDate: [null, [Validators.required]],
      endDate: [null, [Validators.required]],
    });

    this.getAllGoals();
  }

  submitForm() {
    this.userService.postGoal(this.goalForm.value).subscribe(
      (res) => {
        this.message.success('Goal posted successfully', { nzDuration: 5000 });
        this.goalForm.reset();

        this.getAllGoals();
      },
      (error) => {
        this.message.error('Error while posting goal', { nzDuration: 5000 });
      }
    );
  }

  getAllGoals() {
    this.userService.getGoals().subscribe((res) => {
      this.goals = res;
    });
  }

  updateStatus(id: number) {
    this.userService.updateGoalsStatus(id).subscribe(
      (res) => {
        this.message.success('Goal updated successfully', { nzDuration: 5000 });
        this.getAllGoals();
      },
      (error) => {
        this.message.error('Error while upadating goal', { nzDuration: 5000 });
      }
    );
  }
}
