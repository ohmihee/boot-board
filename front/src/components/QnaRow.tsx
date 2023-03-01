import { KeyboardArrowUp } from "@mui/icons-material";
import {
  Box,
  Collapse,
  IconButton,
  Table,
  TableBody,
  TableCell,
  TableRow,
  Typography,
} from "@mui/material";

interface IQna {
  answer: string;
  answerDate: number;
  createDateTime: number;
  openStatus: string;
  question: string;
  questioner: string;
  respondent: string;
}

const QnaRow = ({ row, index }: { row: IQna; index: number }) => {
  return (
    <>
      {" "}
      <TableRow sx={{ "& > *": { borderBottom: "unset" } }}>
        {/* <TableCell>
          <IconButton
            aria-label="expand-row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUp /> : <KeyboardArrowDown />}
          </IconButton>
        </TableCell> */}
        <TableCell align="center">{index}</TableCell>
        <TableCell component="th" scope="row" sx={{ width: 3 / 5 }}>
          {row.question}
        </TableCell>
        <TableCell
          align="center"
          component="th"
          scope="row"
          sx={{ width: 1 / 5 }}
        >
          {row.questioner}
        </TableCell>
        <TableCell>{row.createDateTime}</TableCell>
      </TableRow>
      <TableRow>
        <TableCell
          style={{ paddingBottom: 0, paddingTop: 0, paddingRight: 0 }}
        />
        <TableCell
          style={{ paddingBottom: 0, paddingTop: 0, paddingLeft: 0 }}
          colSpan={6}
        >
          <Collapse in={true} timeout="auto" unmountOnExit>
            <Box sx={{ paddingLeft: 0 }}>
              {/* <Typography variant="h6" gutterBottom component="div">
                응답
              </Typography> */}
              <Table>
                <TableBody>
                  <TableRow>
                    <TableCell>{row.answer}</TableCell>
                  </TableRow>
                  <TableRow>
                    <TableCell align="right" sx={{ padding: 1 }}>
                      답변자: {row.respondent} 답변일: {row.answerDate}
                    </TableCell>
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

export default QnaRow;
