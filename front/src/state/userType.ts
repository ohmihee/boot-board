import {atom} from "jotai";
import {IUser} from "../types/type";

export const userTypeAtom = atom<IUser>({nick:"", password:""})