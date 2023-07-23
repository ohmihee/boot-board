import {KeyboardArrowDown, KeyboardArrowUp} from "@mui/icons-material";
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
    Paper, Button,
} from "@mui/material";
import {Box} from "@mui/system";
import * as React from "react";
import notice from "../state/notice";

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

const CollapseRow = ({row, num}: { row?: test; num: number }) => {
    const [open, setOpen] = React.useState<boolean>(false);
    return (
        <>
            <TableRow sx={{"& > *": {borderBottom: "unset"}}}>
                <TableCell>
                    <IconButton
                        aria-label="expand-row"
                        size="small"
                        onClick={() => setOpen(!open)}
                    >
                        {open ? <KeyboardArrowUp/> : <KeyboardArrowDown/>}
                    </IconButton>
                </TableCell>
                <TableCell align="center">{num}</TableCell>
                <TableCell  component="th" scope="row">
                    {row?.title}
                </TableCell>
                <TableCell >{row?.writer}</TableCell>
                <TableCell>{row?.createDateTime}</TableCell>s
                <TableCell>
                    <Box
                        sx={{width: 30,margin: 0, padding: 1, alignItems:"center",textAlign:"center", backgroundColor: "rgb(246, 245, 232)"}}
                        //variant="contained"
                        //onClick={handleUpsert}
                    >수정
                    </Box>
                </TableCell>
            </TableRow>
            <TableRow>
                <TableCell style={{paddingBottom: 0, paddingTop: 0}} colSpan={6}>
                    <Collapse in={open} timeout="auto" unmountOnExit>
                        <Box sx={{margin: 1}}>
                            {/* <Typography variant="h6" gutterBottom component="div">
                  {row.title}
                </Typography> */}
                            <Table size="small" aria-label="purchases">
                                <TableBody>
                                    <TableRow>{row?.contents[0]?.content}</TableRow>
                                </TableBody>
                            </Table>
                        </Box>
                    </Collapse>
                </TableCell>
            </TableRow>
        </>
    );
};

export default CollapseRow;
