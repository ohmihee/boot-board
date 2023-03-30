import React, {useState} from "react";
import {useMutation, useQuery} from "react-query";
import boardApi from "../api/boardApi";
import {BoardType} from "./type/boardType";

interface IPublic {
    id?: string;
    category?: string;
    contents: [
        {
            order?: number;
            contentType?: string;
            content: string;
        }
    ];
    title: string | undefined;
    writer?: string;
    openStatus: string;
}

export default (id?: string) => {
    const [commonBoard, setCommonBoard] = useState<IPublic>({
        category: "",
        contents: [
            {
                content: "",
            },
        ],
        title: undefined,
        writer: "",
        openStatus: "All",
    });
    const {queryKeyAll, queryFnAll} = boardApi.query.findCommonBoardAll();

    if (id) {
        const {queryKeyById, queryFnById} =
            boardApi.query.findCommonBoardById(id);
        useQuery(queryKeyById, queryFnById, {
            onSuccess: (result) => {
                setCommonBoard(result);
                console.log(result);
            },
        });
    }

    const {data} = useQuery(queryKeyAll, queryFnAll);
    const register = boardApi.mutation.createCommonBoard;
    const registerMutaion = useMutation(register.mutationFn);

    const createCommonBoard = (route: () => void) => {
        console.log(commonBoard, "commonboard===");
        registerMutaion.mutate(commonBoard, {onSuccess: () => route()});
    };

    const setCommonBoardProperties = (key: keyof IPublic, value: string) => {
        setCommonBoard((prev) => {
            return {
                ...prev,
                [key]: value,
            };
        });
    };

    const setCommonBoardContent = (value: string) => {
        setCommonBoard((prev) => {
            return {
                ...prev,
                contents: [
                    {
                        content: value,
                    },
                ],
            };
        });
    };

    const editCommonBoard = async () => {
        await boardApi.editCommonBoardById(commonBoard)
    }

    const removeCommonBoardById = async (id: string) => {
        await boardApi.removeCommonBoardById(id);
    }


    return {
        data,
        commonBoard,
        createCommonBoard,
        setCommonBoardProperties,
        setCommonBoardContent,
    };
};
