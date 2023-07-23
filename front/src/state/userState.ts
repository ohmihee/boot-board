import {useAtom} from "jotai";
import {userTypeAtom} from "./userType";
import {IUser} from "../types/type";
import userApi from "../api/userApi";
import {useMutation} from "react-query";

export default () => {
    const [user, setUser] = useAtom(userTypeAtom);

    const joinMutation =  useMutation(userApi.mutation.joinUser.mutationFn)
    const loginMutation = useMutation(userApi.mutation.loginUser.mutationFn)
    const handleChangeUser = (key: keyof IUser, value: string) => {
        setUser((prev) => {
            return {
                ...prev,
                [key]: value
            }
        })
    }

    const joinUser = (route: () => void) => {
        joinMutation.mutate(user, {onSuccess: () => {
            route()
            }})
    }

    const loginUser = (route: () => void) => {
        loginMutation.mutate(user, {onSuccess: () =>{
            route()
            }})
    }

    return {
        user,
        handleChangeUser,
        joinUser,
        loginUser

    }

}