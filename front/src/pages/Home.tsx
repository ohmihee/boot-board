import { Container, Grid } from "@mui/material";
import { useAtom } from "jotai";
import * as React from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/common/Header";
import LoginForm from "../components/LoginForm";
import { boardTypeAtom } from "../state/boardType";
import Faq from "./Faq";
import Notice from "./Notice";
import Public from "./Public";
import Qna from "./Qna";

interface IHomeProps {}

enum BoardType {
  Public = "Public",
  Notice = "Notice",
  Qna = "Qna",
  Faq = "Faq",
}

const Home: React.FunctionComponent<IHomeProps> = (props) => {
  return (
    <Container>
      <LoginForm />
      {/* <Header />
      <Grid container sx={{ mt: "15px" }}>
        <Outlet />
      </Grid> */}
    </Container>
  );
};

export default Home;
