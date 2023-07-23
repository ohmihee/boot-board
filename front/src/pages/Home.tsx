import { Container, Grid } from "@mui/material";
import { useAtom } from "jotai";
import * as React from "react";
import {Outlet, useNavigate} from "react-router-dom";
import Header from "../components/common/Header";
import LoginForm from "../components/LoginForm";
import { boardTypeAtom } from "../state/boardType";
import Faq from "./Faq";
import Notice from "./Notice";
import Public from "./Public";
import Qna from "./Qna";
import userState from "../state/userState";
import {IUser} from "../types/type";

interface IHomeProps {}

enum BoardType {
  Public = "Public",
  Notice = "Notice",
  Qna = "Qna",
  Faq = "Faq",
}

const Home: React.FunctionComponent<IHomeProps> = (props) => {
  const navigate = useNavigate();
  const { user, loginUser, handleChangeUser } = userState();

  const onHandleChangeUser = (key: keyof IUser) => (e: React.ChangeEvent<HTMLInputElement>) => {
    handleChangeUser(key, e.target.value);
  };

  const onClickLogin = () => {
    loginUser(()=>navigate("/notice"))
  }
  return (
    <Container>
      {/*<LoginForm user={user} onClickLogin={onClickLogin} onChangeUserProperties={onHandleChangeUser}/>*/}
      <Header />
      <Grid container sx={{ mt: "15px" }}>
        <Outlet />
      </Grid>
    </Container>
  );
};

export default Home;
