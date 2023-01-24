import { Box, Grid, Link, Toolbar, Typography } from "@mui/material";
import * as React from "react";

interface IHeaderProps {}

const Header: React.FunctionComponent<IHeaderProps> = (props) => {
  const sections = [
    {
      url: "",
      title: "public",
    },
    {
      uri: "",
      title: "notify",
    },
    {
      uri: "",
      title: "faq",
    },
    {
      uri: "",
      title: "qna",
    },
  ];

  return (
    <Grid className="header">
      {/* <Box
            component='img'
            // src="header.png"
            width='5vw'
        /> */}
      <Toolbar sx={{ borderBottom: 1, borderColor: "divider" }}>
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
          borderColor: "divider",
          backgroundColor: "#fffef2",
          color: "#333",
        }}
      >
        {sections.map((section) => (
          <Link
            color="inherit"
            noWrap
            key={section.title}
            variant="body2"
            href={section.url}
            sx={{ p: 1, flexShrink: 0 }}
          >
            {section.title}
          </Link>
        ))}
      </Toolbar>
    </Grid>
  );
};

export default Header;
