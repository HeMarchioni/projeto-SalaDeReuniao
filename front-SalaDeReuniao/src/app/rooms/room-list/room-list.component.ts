import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {Room} from "../room";
import {RoomService} from "../room.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  rooms: Observable<Room[]>;

  constructor(private roomService: RoomService, private router: Router) {}

  ngOnInit() {
    this.rooms = this.roomService.getRoomsList();
  }


  deleteRoom(id: number) {
    this.roomService.deleteRoom(id)
        .subscribe(
            data => {
              console.log(data);
              this.ngOnInit();
            },
            error => console.log(error));
  }

  roomDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }
}
