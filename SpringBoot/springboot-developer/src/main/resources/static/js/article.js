const deleteButton = document.getElementById('delete-btn');
if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        // fetch(`주소`, { 데이터전송에 필요한 설정들 })
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            //fetch가 성공했을 때 실행되는 부분
            .then(() => {
                alert('삭제가 완료되었습니다.');
                // 목록 페이지 이동
                location.replace("/articles");
            })
            // fetch가 실패했을때 실행
            .catch(() => {
                alert("삭제에 실패했습니다.");
            })
    })
}
// fetch : catch 실행시 then 에서 직접 처리를 해야한다, json 데이터 사용시 수동으로 변환이 필요
// axios : 에러 발생시 자동으로 catch 실행, json데이터를 자동으로 변환
const axiosDeleteBtn2 = document.getElementById('axios-delete-btn2');
if (axiosDeleteBtn2) {
    axiosDeleteBtn2.addEventListener("click", async (event) => {
        try {
            let id = document.getElementById('article-id').value;
            const response = await axios.delete(`/api/articles/${id}`);
            alert('삭제가 완료되었습니다.');
            location.replace("/articles");
        } catch (error) {
            console.log(error);
            alert("삭제에 실패했습니다.");
        }
    })

}
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            })
    })
}