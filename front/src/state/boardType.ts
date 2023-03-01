import { atom } from "jotai";
import { BoardType } from "./type/boardType";

export const boardTypeAtom = atom<BoardType>(BoardType.Public);
