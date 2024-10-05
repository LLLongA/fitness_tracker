import { Routes } from '@angular/router';
import { ActivityComponent } from '../components/activity/activity.component';
import { WorkoutComponent } from '../components/workout/workout.component';
import { GoalComponent } from '../components/goal/goal.component';

export const routes: Routes = [
  { path: 'activity', component: ActivityComponent },
  { path: 'workout', component: WorkoutComponent },
  { path: 'goal', component: GoalComponent },
];
