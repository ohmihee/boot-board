import {
  TableRow,
  TableCell,
  IconButton,
  Collapse,
  Typography,
  Table,
  TableBody,
  TableHead,
} from "@mui/material";
import React from "react";
import {
  CheckBox,
  KeyboardArrowDown,
  KeyboardArrowUp,
} from "@mui/icons-material";
import { Box } from "@mui/system";

interface IFaq {
  id: string;
  title: string;
  answer: string;
  writer: string;
  question: string;
  createDateTime: number;
  lastModifiedDate: number;
}
const FaqRow = ({ row }: { row: IFaq }) => {
  const [open, setOpen] = React.useState<boolean>(false);
  return (
    <>
      <TableRow sx={{ "& > *": { borderBottom: "unset" } }}>
        {/* 관리자인 경우
      <TableCell>
          <CheckBox />
        </TableCell>
        <TableCell component="th" scope="row">
          <IconButton
            aria-label="expand-row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
          </IconButton>
          Q: {row.question}
        </TableCell> */}
        <TableCell>
          <IconButton
            aria-label="expand-row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
          </IconButton>
        </TableCell>
        <TableCell component="th" scope="row">
          Q: {row.question}
        </TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} />
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            {/* <Box>
              <Typography variant="h6" gutterBottom component="div">
                요청질문
              </Typography>
              <Table>
                <TableBody>
                  <TableRow>
                    <TableCell>{row.question}</TableCell>
                  </TableRow>
                </TableBody>
              </Table>
            </Box> */}

            <Box>
              <Typography variant="h6" gutterBottom component="div">
                A:
              </Typography>
              <Table>
                <TableBody>
                  <TableRow>
                    <TableCell>{row.answer}</TableCell>
                  </TableRow>
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </>
  );
};

export default FaqRow;
