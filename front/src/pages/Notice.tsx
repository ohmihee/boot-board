import {
  TableRow,
  TableCell,
  Table,
  TableHead,
  TableBody,
  TableContainer,
  Paper,
  Button,
} from "@mui/material";
import { Box } from "@mui/system";
import * as React from "react";
import { Link } from "react-router-dom";
import CollapseRow from "../components/CollapseRow";
import notice from "../state/notice";
import common from "../state/common";

interface INoticeProps {}
interface test {
  title: string;
  contents: [
    {
      order: number;
      contentType: string;
      content: string;
    }
  ];
  writer: string;
  createDateTime: number;
}
const Notice: React.FunctionComponent<INoticeProps> = (props) => {
  const { data }: { data?: test[] } = notice();
  //const { createCommonBoard } = common();

  return (
    <>
      <TableContainer component={Paper}>
        <Table aria-label="collapsible table">
          <TableHead>
            <TableRow>
              <TableCell align="left" sx={{ width: 0, padding: 0 }} />
              <TableCell align="center" sx={{ width: 40 }}>
                번호
              </TableCell>
              <TableCell>제목</TableCell>
              <TableCell>작성자</TableCell>
              <TableCell>등록일</TableCell>
              <TableCell></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data &&
              data?.map((row: test, index: number) => (
                <CollapseRow key={index} row={row} num={index + 1} />
              ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Link to="/notice/form">
        <Button
          sx={{ marginTop: 2, marginLeft: "74vw", backgroundColor: "#1982b3" }}
          variant="contained"
        >
          등록
        </Button>
      </Link>
    </>
  );
};

export default Notice;
