import {
  TableContainer,
  Table,
  TableHead,
  TableCell,
  Paper,
  TableBody,
  TableRow,
  Button,
} from "@mui/material";
import * as React from "react";
import { Link } from "react-router-dom";
import FaqRow from "../components/FaqRow";
import faq from "../state/faq";

interface IFnaProps {}

interface IFaq {
  id: string;
  title: string;
  answer: string;
  writer: string;
  question: string;
  createDateTime: number;
  lastModifiedDate: number;
}

const Faq: React.FunctionComponent<IFnaProps> = (props) => {
  const { data }: { data: IFaq[] } = faq();

  return (
    <>
      <TableContainer component={Paper}>
        <Table aria-label="collapsible table">
          <TableHead>
            <TableRow>
              <TableCell className="table-num" align="left"></TableCell>
              <TableCell align="center">제목</TableCell>
              <TableCell align="center"></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {data?.map((ele: IFaq, index: number) => (
              <FaqRow key={index} row={ele || []} />
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

export default Faq;
