import { Box, Button, Grid, TextField } from "@mui/material";
import { Link, useLocation, useNavigate } from "react-router-dom";
import common from "../state/common";

interface IPublicForm {}

const PublicForm: React.FunctionComponent<IPublicForm> = () => {
  const location = useLocation();
  const path = location.pathname.split("form/");
  const {
    createCommonBoard,
    setCommonBoardTitle,
    setCommonBoardContent,
    commonBoard,
  } = common(path[1]);

  const navigate = useNavigate();

  const route = () => {
    navigate("/");
  };

  return (
    <>
      <Box
        sx={{
          width: "75vw",
          maxWidth: "100%",
          padding: "auto",
          margin: "auto",
        }}
      >
        <TextField
          onChange={(e) => {
            setCommonBoardTitle("title", e.target.value);
          }}
          fullWidth
          label={commonBoard?.title ?? "제목을 입력하세요"}
          id="fullWidth"
        />
        <TextField
          sx={{
            margin: 0,
            padding: 0,
            input: { height: "60vh" },
          }}
          onChange={(e) => {
            setCommonBoardContent(e.target.value);
          }}
          fullWidth
          label="내용을 입력하세요"
          id="fullWidth"
        />
        <Button
          sx={{ marginTop: 2, backgroundColor: "#1982b3" }}
          variant="contained"
          onClick={() => createCommonBoard(route)}
        >
          완료
        </Button>
        <Link to="/">
          <Button
            sx={{ marginTop: 2, backgroundColor: "#1982b3", marginLeft: 2 }}
            variant="contained"
          >
            목록
          </Button>
        </Link>
      </Box>
    </>
  );
};

export default PublicForm;
