import { Container, Grid } from "@mui/material";
import { useAtom } from "jotai";
import * as React from "react";
import { Outlet } from "react-router-dom";
import Header from "../components/common/Header";
import { boardTypeAtom } from "../state/boardType";
import Faq from "./Faq";
import Notice from "./Notice";
import Public from "./Public";
import Qna from "./Qna";

interface IHomeProps {}

// export enum ContentType {
//   Information = "Information",
//   Video = "Video",
//   LearningMap = "LearningMap",
// }

enum BoardType {
  Public = "Public",
  Notice = "Notice",
  Qna = "Qna",
  Faq = "Faq",
}

const Home: React.FunctionComponent<IHomeProps> = (props) => {
  //const [boardType, setBoardType] = React.useState<BoardType>(BoardType.Public);
  //const { boardType } = common;
  //const [boardType, setBoardType] = useAtom<BoardType>(common);
  //const { boardType } = common;

  // const [boardType, setBoardType] = useAtom(boardTypeAtom);

  // React.useEffect(() => {
  //   console.log(boardType);
  // }, [boardType]);

  // const renderBoard = () => {
  //   if (boardType === BoardType.Public) {
  //     return <Public />;
  //   }
  //   if (boardType === BoardType.Qna) {
  //     return <Qna />;
  //   }
  //   if (boardType === BoardType.Faq) {
  //     return <Faq />;
  //   }
  //   if (boardType === BoardType.Notice) {
  //     return <Notice />;
  //   }
  // };
  return (
    <Container>
      <Header />
      <Grid container sx={{ mt: "15px" }}>
        {/* {renderBoard()} */}
        <Outlet />
      </Grid>
    </Container>
  );
};

export default Home;
