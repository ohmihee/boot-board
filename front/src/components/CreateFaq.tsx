import { Box, Button, TextField } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

const CreateFaq = () => {
  return (
    <React.Fragment>
      <Box
        sx={{
          width: "75vw",
          maxWidth: "100%",
          padding: "auto",
          margin: "auto",
        }}
      >
        <TextField
          //onChange={onChangeTitle("title")}
          fullWidth
          //label={commonBoard?.title ?? "제목을 입력하세요"}
          label={"제목을 입력하세요"}
          id="fullWidth"
        />
        <TextField
          sx={{
            margin: 0,
            padding: 0,
            input: { height: "60vh" },
          }}
          //onChange={onChangeContent}
          fullWidth
          label="내용을 입력하세요"
          id="fullWidth"
        />
        <Button
          sx={{ marginTop: 2, backgroundColor: "#1982b3" }}
          variant="contained"
          //onClick={onClickConfirm}
        >
          완료
        </Button>
        <Link to="/faq">
          <Button
            sx={{ marginTop: 2, backgroundColor: "#1982b3", marginLeft: 2 }}
            variant="contained"
          >
            목록
          </Button>
        </Link>
      </Box>
    </React.Fragment>
  );
};
