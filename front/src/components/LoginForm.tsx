import {Grid} from "@mui/material";
import React from "react";
import {IUser} from "../types/type";

const LoginForm = ({user, onClickLogin, onChangeUserProperties}: {
    user: IUser,
    onClickLogin: () => void,
    onChangeUserProperties: (key: keyof IUser) => (e: React.ChangeEvent<HTMLInputElement>) => void
}) => {
    return (
        <React.Fragment>
            <form className="center">
                <div id="login_form" className="form_class">
                    <div className="form_div">
                        <label>Login:</label>
                        <input
                            className="field_class"
                            name="login_txt"
                            type="text"
                            placeholder="ID"
                            value={user?.nick}
                            onChange={onChangeUserProperties("nick")}
                        />
                        <label>Password:</label>
                        <input
                            id="pass"
                            className="field_class"
                            name="password_txt"
                            type="password"
                            placeholder="Password"
                            value={user?.password}
                            onChange={onChangeUserProperties("password")}
                        />
                        <div className="submit_class" onClick={onClickLogin}>
                            Enter
                        </div>
                    </div>
                </div>
            </form>
        </React.Fragment>
    );
};

export default LoginForm;
