import { KeyboardArrowDown, KeyboardArrowUp } from "@mui/icons-material";
import {
  IconButton,
  TableRow,
  TableCell,
  Collapse,
  Typography,
  Table,
  TableHead,
  TableBody,
  TableContainer,
  Paper,
} from "@mui/material";
import { Box } from "@mui/system";
import * as React from "react";
import CollapseRow from "../components/CollapseRow";
import notice from "../state/notice";

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
  const { data }: { data: test[] } = notice();
  console.log(data);

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
    </>
  );
};

export default Notice;
