function updatePlanForm(idx) {
    location.replace(`/plan/update-form/${idx}`);
}

function deletePlan(idx) {
    $.ajax({
        method: "DELETE",
        url: "/plan/delete",
        data: {'idx': idx},
        success: function () {
            location.reload();
        }
    })
}

function askReallyDelete(idx) {
    if (confirm("정말로 일정을 삭제하시겠습니까?")) {
        deletePlan(idx)
    }
}

function askReallyPubToggle(idx,pub) {
    if (confirm("공개 여부를 변경하시겠습니까?")) {
        pubToggle(idx,pub)
    }
}
function pubToggle(idx,pub) {
    $.ajax({
        method: 'PUT',
        url: '/plan/pub-toggle',
        data: {'idx': Number(idx), 'pub': Number(pub)},
        success: function () {
            location.replace("/plan/my");
        }
    })
}