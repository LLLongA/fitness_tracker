import { Component } from '@angular/core';
import { SharedModule } from '../../app/shared/shared.module';
import { UserService } from '../../app/service/user.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent {
  statsData: any;
  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getStats();
  }

  getStats() {
    this.userService.getStats().subscribe((res) => {
      console.log(res);
      this.statsData = res;
    });
  }
}
