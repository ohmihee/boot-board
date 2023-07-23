import {IUser} from "../types/type";
import {postApi} from "./api";

const path = "api/v1/users"
export const joinUser = (data: IUser) => postApi(`${path}/join`, data);

export const loginUser = (data: IUser) => postApi(`${path}/login`, data);

export default {
    joinUser,
    loginUser,
    mutation: {
        joinUser: {
            mutationFn: async(data: IUser) => await joinUser(data)
        },
        loginUser: {
            mutationFn: async (data: IUser) => await loginUser(data)
        }
    }
}