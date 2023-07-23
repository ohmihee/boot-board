import { Box, Grid, Toolbar, Typography } from "@mui/material";
import { useAtom } from "jotai";
import * as React from "react";
import { boardTypeAtom } from "../../state/boardType";
import { BoardType } from "../../state/type/boardType";
import { Link } from "react-router-dom";

interface IHeaderProps {}

const Header: React.FunctionComponent<IHeaderProps> = (props) => {
  const [boardType, setBoardType] = useAtom(boardTypeAtom);
  const sections = [
    {
      url: "/",
      title: "Public",
      type: BoardType.Public,
    },
    {
      url: "/notice",
      title: "Notice",
      type: BoardType.Notice,
    },
    {
      url: "/faq",
      title: "Faq",
      type: BoardType.Faq,
    },
    {
      url: "/qna",
      title: "Qna",
      type: BoardType.Qna,
    },
  ];

  return (
    <Grid className="header">
      {/* <Box
            component='img'
            // src="header.png"
            width='5vw'
        /> */}
      <Toolbar sx={{ borderBottom: 1, borderColor: "#29367c" }}>
        <Typography
          component="h2"
          variant="h5"
          color="#333"
          align="center"
          noWrap
          sx={{ flex: 1 }}
        >
          POST
        </Typography>
      </Toolbar>
      <Toolbar
        component="nav"
        variant="dense"
        sx={{
          justifyContent: "space-between",
          overflowX: "auto",
          borderBottom: 1,
          borderColor: "#29367c",
          backgroundColor: "#fffef2",
          color: "#333",
        }}
      >
        {sections.map((section) => (
          <Link
            color="inherit"
            className="header-style"
            //noWrap
            key={section.title}
            //variant="body2"
            to={section.url}
            //sx={{ p: 1, flexShrink: 0 }}
          >
            {section.title}
          </Link>
        ))}
      </Toolbar>
    </Grid>
  );
};

export default Header;
