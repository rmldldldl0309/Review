import React, { useEffect, useRef, useState } from 'react'

/*
107개의 게시물, 한페이지 당 5개씩 보여줌     - 총 페이지 수 22페이지
totalPageCount = boardCount / 5
if(boardCount % 5 !== 0) totalPageCount + 1;
or
totalPageCount = Math.floor((boardCount - 1) / 5)

페이지네이션을 한 섹션당 10개                     - 섹션 3개
totalSectionCount = Math.floor(totalPageCount - 1) / 10
=>
totalSectionCount = Math.floor(boardCount - 1) / (5*10)

=============================================================================
boardList =  [a0, a1, a2, a3, ... , a106];
1페이지, [a0 ~ a4]
2페이지, [a5 ~ a9]
...
21페이지, [a100 ~ a1041]
22페이지, [a105, a106]
currentPageStart = 5 * (page - 1)
currentPageEnd = 5 * page - 1

viewList = [];
for ( index = currentPageStart; index <= currentPageEnd; index ++ ) {
    if (index >= boardList.length)  break;
    viewList.push(boardList[index]);
}

===============================================================================
currentSectionStart = 10 * section - 9 >                > 9는 의미 있는 숫자이다 > 값이 기준에 따라 변하므로 > 상수로 
currentSectionEnd = 10 * section

viewPageList = [];
for ( index = currentSectionStart; index <= currentSectionEnd; index ++ ) {
    if (index > totalPage)  break;
    viewList.push(index);
}
 */

// Custom Hook : 
// - 리액트의 훅 함수는 반드시 함수형 컴포넌트의 코드 블럭에서만 호출 가능
// - 함수명을 use로 시작하게 작성하여 커스텀 훅 함수를 만들 수 있다
// - 커스텀 훅 함수에는 다른 훅 함수를 포함할 수 있다

function usePagination (totalList: string[]) {
    const [page, setPage] = useState<number>(1);
    const [section, setSection] = useState<number>(1);
    const [boardList, setBoardList] = useState<string[]>([]);
    const [viewList, setViewLIst] = useState<string[]>([]);
    const [viewPageList, setViewPageList] = useState<number[]>([]);

    const totalPageCount = useRef<number>(1);
    const totalSectionCount = useRef<number>(1);

    const COUNT_PER_PAGE = 5;
    const COUNT_PER_SECTION = 10;

    const setNextSection = () => { 
        if (section === totalSectionCount.current) return;
        setSection(section + 1);
        const page = (section) * COUNT_PER_SECTION + 1
        setPage(page);
    }

    const setPreviousSection = () => {
        if (section === 1) return;
        setSection(section - 1);
        const page = (section - 1) * COUNT_PER_SECTION;
        setPage(page);
    }

    const changeViewList = (boardList: string[]) => {
        const viewList = [];
        const currentPageStart = COUNT_PER_PAGE * (page - 1);
        const currentPageEnd = COUNT_PER_PAGE * page - 1;

        for (let index = currentPageStart; index <= currentPageEnd; index ++) {
            if (boardList.length <= index) break; 
            viewList.push(boardList[index]);
        }
        setViewLIst(viewList);
    }

    const changeViewPageList = () => {
        const viewPageList = [];
        const currentSectionStart = COUNT_PER_SECTION * section - (COUNT_PER_SECTION - 1);
        const currentSectionEnd = COUNT_PER_SECTION * section

        for (let page = currentSectionStart; page <= currentSectionEnd; page ++) {
            if (totalPageCount.current < page) break; 
            viewPageList.push(page);
        }
        setViewPageList(viewPageList);
    }

    // 안에 리터럴 7개
    // 빈 배열이므로 mount에서 동작
    useEffect(() => {
        const boardList = totalList;
        setBoardList(boardList);
        totalPageCount.current = Math.floor((boardList.length - 1) / COUNT_PER_PAGE) + 1;
        totalSectionCount.current = Math.floor((boardList.length - 1) / (COUNT_PER_PAGE * COUNT_PER_SECTION)) + 1;

        const viewList = [];
        const currentPageStart = COUNT_PER_PAGE * (page - 1);
        const currentPageEnd = COUNT_PER_PAGE * page - 1;

        for (let index = currentPageStart; index <= currentPageEnd; index ++) {
            if (boardList.length <= index) break; 
            viewList.push(boardList[index]);
        }
        setViewLIst(viewList);

        const viewPageList = [];
        const currentSectionStart = COUNT_PER_SECTION * section - (COUNT_PER_SECTION - 1);
        const currentSectionEnd = COUNT_PER_SECTION * section

        for (let page = currentSectionStart; page <= currentSectionEnd; page ++) {
            if (totalPageCount.current < page) break; 
            viewPageList.push(page);
        }
        setViewPageList(viewPageList);

        changeViewList(boardList);
        changeViewPageList();
    }, []);

    useEffect(() => {
        if (!boardList.length) return;
        changeViewList(boardList);
    }, [page])

    useEffect(() => {
        changeViewPageList();
    }, [section])

    return {
        page, setPage, viewList, viewPageList, setPreviousSection, setNextSection
    }
}

export default function CustomHook() {

    const {page, setPage, viewList, viewPageList, setPreviousSection, setNextSection} = usePagination(BOARD_LIST);

    return (
        <div>
            {viewList.map((item, index) => <h3 key={index}>{item}</h3>)}
            <div>
                <span style={{display: 'inline-block', margin: '4px'}} onClick={setPreviousSection}>이전</span>
                {viewPageList.map((item, index) => <span key={index} style={{display: 'inline-block', 
                margin: '4px', fontWeight: item === page? 900 : 400}} onClick={() => setPage(item)}>{item}</span>)}
                <span style={{display: 'inline-block', margin: '4px'}} onClick={setNextSection}>이후</span>
            </div>
        </div>
    )
}
const BOARD_LIST = [
    '게시물1',
    '게시물2',
    '게시물3',
    '게시물4',
    '게시물5',
    '게시물6',
    '게시물7',
    '게시물8',
    '게시물9',
    '게시물10',
    '게시물11',
    '게시물12',
    '게시물13',
    '게시물14',
    '게시물15',
    '게시물16',
    '게시물17',
    '게시물18',
    '게시물19',
    '게시물20',
    '게시물21',
    '게시물22',
    '게시물23',
    '게시물24',
    '게시물25',
    '게시물26',
    '게시물27',
    '게시물28',
    '게시물29',
    '게시물30',
    '게시물31',
    '게시물32',
    '게시물33',
    '게시물34',
    '게시물35',
    '게시물36',
    '게시물37',
    '게시물38',
    '게시물39',
    '게시물40',
    '게시물41',
    '게시물42',
    '게시물43',
    '게시물44',
    '게시물45',
    '게시물46',
    '게시물47',
    '게시물1',
    '게시물2',
    '게시물3',
    '게시물4',
    '게시물5',
    '게시물6',
    '게시물7',
    '게시물8',
    '게시물9',
    '게시물10',
    '게시물11',
    '게시물12',
    '게시물13',
    '게시물14',
    '게시물15',
    '게시물16',
    '게시물17',
    '게시물18',
    '게시물19',
    '게시물20',
    '게시물21',
    '게시물22',
    '게시물23',
    '게시물24',
    '게시물25',
    '게시물26',
    '게시물27',
    '게시물28',
    '게시물29',
    '게시물30',
    '게시물31',
    '게시물32',
    '게시물33',
    '게시물34',
    '게시물35',
    '게시물36',
    '게시물37',
    '게시물38',
    '게시물39',
    '게시물40',
    '게시물41',
    '게시물42',
    '게시물43',
    '게시물44',
    '게시물45',
    '게시물46',
    '게시물47',
    '게시물1',
    '게시물2',
    '게시물3',
    '게시물4',
    '게시물5',
    '게시물6',
    '게시물7',
    '게시물8',
    '게시물9',
    '게시물10',
    '게시물11',
    '게시물12',
    '게시물13',
]


