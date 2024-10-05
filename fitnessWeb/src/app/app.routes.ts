import { Routes } from '@angular/router';
import { ActivityComponent } from '../components/activity/activity.component';
import { WorkoutComponent } from '../components/workout/workout.component';

export const routes: Routes = [
  { path: 'activity', component: ActivityComponent },
  { path: 'workout', component: WorkoutComponent },
];
