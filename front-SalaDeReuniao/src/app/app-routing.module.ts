import {RouterModule, Routes} from "@angular/router";
import {RoomListComponent} from "./rooms/room-list/room-list.component";
import {CreateRoomComponent} from "./rooms/create-room/create-room.component";
import {UpdateRoomComponent} from "./rooms/update-room/update-room.component";
import {RoomDetailsComponent} from "./rooms/room-details/room-details.component";
import {NgModule} from "@angular/core";


const routes: Routes = [
    { path: '', redirectTo: 'rooms', pathMatch: 'full' },
    { path: 'rooms', component: RoomListComponent },
    { path: 'add', component: CreateRoomComponent },
    { path: 'update/:id', component: UpdateRoomComponent },
    { path: 'details/:id', component: RoomDetailsComponent },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
