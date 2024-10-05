import { Component } from '@angular/core';
import { SharedModule } from '../../app/shared/shared.module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageComponent, NzMessageService } from 'ng-zorro-antd/message';
import { UserService } from '../../app/service/user.service';

@Component({
  selector: 'app-workout',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './workout.component.html',
  styleUrl: './workout.component.scss',
})
export class WorkoutComponent {
  gridstyle = {
    width: '100%',
    textAlign: 'center',
  };

  workoutForm!: FormGroup;

  listOfType: any[] = [
    'Cardio',
    'Strength',
    'Flexbility',
    'HIIT',
    'Pilates',
    'Dance',
    'Swimming',
    'Cycling',
    'Running',
    'Walking',
    'Boxing',
    'CrossFit',
    'Rowing',
    'Stretching',
    'Material Arts',
    'Gymnastics',
    'Climbing',
    'Plymetrics',
  ];

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private message: NzMessageService
  ) {}

  ngOnInit() {
    this.workoutForm = this.fb.group({
      type: [null, [Validators.required]],
      duration: [null, [Validators.required]],
      date: [null, [Validators.required]],
      caloriesBurned: [null, [Validators.required]],
    });
  }
}