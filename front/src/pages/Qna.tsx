import {
  Button,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from "@mui/material";
import { useAtom } from "jotai";
import * as React from "react";
import { Link } from 'react-router-dom';
import QnaRow from "../components/QnaRow";
import { boardTypeAtom } from "../state/boardType";
import common from "../state/common";
import qna from "../state/qna";
import { BoardType } from "../state/type/boardType";

interface IQnaProps {}

interface IQna {
  answer: string;
  answerDate: number;
  createDateTime: number;
  openStatus: string;
  question: string;
  questioner: string;
  respondent: string;
}

const Qna: React.FunctionComponent<IQnaProps> = (props) => {
  const { data }: { data: IQna[] } = qna();
  console.log(data);
  return (
    <>
      <TableContainer component={Paper}>
        <Table aria-label="collapsible table">
          <TableHead>
            <TableRow>
              <TableCell className="table-num" align="left">
                번호
              </TableCell>
              <TableCell align="center">제목</TableCell>
              <TableCell align="center">작성자</TableCell>
              <TableCell align="center">등록일</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data?.map((ele: IQna, index: number) => (
              <QnaRow key={index} row={ele || []} index={index + 1} />
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Link to="/faq/form">
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

export default Qna;
