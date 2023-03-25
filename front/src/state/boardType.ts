import { atom } from "jotai";
import { BoardType } from "./type/boardType";

export const boardTypeAtom = atom<BoardType>(BoardType.Public);

// const textAtom = atom<string>("test");
// const upperCateAtom = atom((get) => get(textAtom).toUpperCase());
