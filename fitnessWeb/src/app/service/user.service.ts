import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const BASIC_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}
  postActivity(activityDto: any): Observable<any> {
    return this.http.post(BASIC_URL + '/api/activity', activityDto);
  }

  getActivities(): Observable<any> {
    return this.http.get(BASIC_URL + '/api/activities');
  }

  postWorkout(workoutDto: any): Observable<any> {
    return this.http.post(BASIC_URL + '/api/workout', workoutDto);
  }

  getWorkouts(): Observable<any> {
    return this.http.get(BASIC_URL + '/api/workouts');
  }

  postGoal(goalDto: any): Observable<any> {
    return this.http.post(BASIC_URL + '/api/goal', goalDto);
  }

  getGoals(): Observable<any> {
    return this.http.get(BASIC_URL + '/api/goals');
  }

  updateGoalsStatus(id: number): Observable<any> {
    return this.http.get(BASIC_URL + '/api/goals/status/' + id);
  }

  getStats(): Observable<any> {
    return this.http.get(BASIC_URL + '/api/stats');
  }
}
