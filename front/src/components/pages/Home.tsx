import { Container, Grid } from "@mui/material";
import * as React from "react";
import Header from "../common/Header";
import Public from "./Public";

interface IHomeProps {}

const Home: React.FunctionComponent<IHomeProps> = (props) => {
  return (
    <Container>
      <Header />
      <Grid container sx={{ mt: "15px" }}>
        <Public />
      </Grid>
    </Container>
  );
};

export default Home;
