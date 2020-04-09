

    $(document).ready(function(){        
        $("#check_maSP").click(function check_maSP(){
            let ipMD_ma = document.getElementById("MD_maSP").value;
            let dateNow = new Date(); 
            $.ajax({url :"http://localhost:8080/doiHang/getOneSalesByMa?license="+ipMD_ma})
                .then(function(dataSale){
                    if (ipMD_ma == dataSale.license) {
                        let modaldata = document.getElementById("modaldata")
                            modaldata.innerHTML="";
                            let contents = "";
                                contents +=`
                                <div class="MD-frames-ifor-order mt-2 mb-2" >
                                            <div class="MD-frames-line d-flex justify-content-start mt-3">
                                                <i class="MD-icon-check fas fa-check-circle"></i>
                                                <h5 class="MD-line-title">Don Hang : </h5>
                                                <p class="MD-line-content pl-1">AH-451478</p>
                                            </div>
                                            <div class="MD-frames-line d-flex justify-content-start">
                                                <i class="MD-icon-check fas fa-check-circle"></i>
                                                <h5 class="MD-line-title">Ten Khac Hang : </h5>
                                                <p class="MD-line-content pl-1">Nguyen Thi A / 012345679 / so 7 Nguyen Thi A, P HX</p>
                                            </div>
                                            <div class="MD-frames-line d-flex justify-content-start">
                                                <i class="MD-icon-check fas fa-check-circle"></i>
                                                <h5 class="MD-line-title">Thanh Tien : </h5>
                                                <p class="MD-line-content pl-1">0123456789</p>
                                            </div>
                                            <div class="MD-frames-line d-flex justify-content-start">
                                                <i class="MD-icon-check fas fa-check-circle"></i>
                                                <h5 class="MD-line-title">Ngay Tao : </h5>
                                                <p class="MD-line-content pl-1">XXX</p>
                                            </div>
                    
                                            <div class="MD-btn-end col-xl-12 d-flex justify-content-end">
                                                <button type="button" class="btn btn-primary MD-btn-next btn-next" onclick="clickmodal()" id="btn_next">Next>></button>
                                            </div>
                                        </div>`;
                                $(contents).appendTo(modaldata);                          
                    }else if(ipMD_ma != dataSale.license){
                        alert("Sorry ! Ma Hang Khong Ton Tai.")
                    }
                    
                })
        })
    })


    //<!-- JS modal doi hang -->
    function clickmodal(){
        $("div[id^='myModal']").each(function(){
            debugger;
            var currentModal = $(this);
            //click next
            currentModal.find('.btn-next').click(function(){
                currentModal.modal('hide');
                currentModal.closest("div[id^='myModal']").nextAll("div[id^='myModal']").first().modal('show'); 
            });
            
            //click prev
            // currentModal.find('.btn-prev').click(function(){
            //     currentModal.modal('hide');
            //     currentModal.closest("div[id^='myModal']").prevAll("div[id^='myModal']").first().modal('show'); 
            // });

            });
    }
        
    // if (dateNow - dataSale.dateSales > 3) {
    //     let modaldata = document.getElementById("modaldata")
    //     modaldata.innerHTML="";
    //     let contents = "";
    //         contents +=`
    //         <div class="MD-frames-ifor-order mt-2 mb-2" >
    //                     <div class="MD-frames-line d-flex justify-content-start mt-3">
    //                         <i class="MD-icon-check fas fa-check-circle"></i>
    //                         <h5 class="MD-line-title">Don Hang : </h5>
    //                         <p class="MD-line-content pl-1">AH-451478</p>
    //                     </div>
    //                     <div class="MD-frames-line d-flex justify-content-start">
    //                         <i class="MD-icon-check fas fa-check-circle"></i>
    //                         <h5 class="MD-line-title">Ten Khac Hang : </h5>
    //                         <p class="MD-line-content pl-1">Nguyen Thi A / 012345679 / so 7 Nguyen Thi A, P HX</p>
    //                     </div>
    //                     <div class="MD-frames-line d-flex justify-content-start">
    //                         <i class="MD-icon-check fas fa-check-circle"></i>
    //                         <h5 class="MD-line-title">Thanh Tien : </h5>
    //                         <p class="MD-line-content pl-1">0123456789</p>
    //                     </div>
    //                     <div class="MD-frames-line d-flex justify-content-start">
    //                         <i class="MD-icon-check fas fa-check-circle"></i>
    //                         <h5 class="MD-line-title">Ngay Tao : </h5>
    //                         <p class="MD-line-content pl-1">XXX</p>
    //                     </div>

    //                     <div class="MD-btn-end col-xl-12 d-flex justify-content-end">
    //                         <button type="button" class="btn btn-primary MD-btn-next btn-next" onclick="clickmodal()" id="btn_next">Next>></button>
    //                     </div>
    //                 </div>`;
    //         $(contents).appendTo(modaldata);
    // }

