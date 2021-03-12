import { Institute } from "./institute";
import { Location } from "./location";
import { Skill } from "./skill";

export interface Grad{
    id:number;
    name:string;
    ten_join_date:string;
    description:string;
    feedback:string;
    contact:string;
    email:string;
    join_loc:Location;
    loc:Location;
    institute:Institute;
    skills: Skill[];
}