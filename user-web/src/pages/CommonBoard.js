import Board from "@/pages/Board";

export default function createCommonBoard(name) {
  return {
    name,
    render(createElement) {
      return createElement(Board);
    }
  };
}
